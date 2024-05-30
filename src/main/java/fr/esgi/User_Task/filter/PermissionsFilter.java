package fr.esgi.User_Task.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.User_Task.application.dto.permission.JwtPayload;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class PermissionsFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(PermissionsFilter.class);

    private String[] adminMethodAllowed = {
            "nouveau-catalogue", "get-all-catalogues", "get-catalogue-by-id", "modifie-catalogue", "supprimer-catalogue",
            "nouveau-tache", "get-all-taches", "get-tache-by-id", "modifie-tache", "supprimer-tache",
            "nouveau-utilisateur", "get-utilisateur-by-id", "modifie-utilisateur", "modifie-utilisateur"
    };

    private String[] userMethodAllowed = {
            "get-all-catalogues", "get-catalogue-by-id", "get-all-taches", "get-tache-by-id"
    };

    private String[] modMethodAllowed = {
            "nouveau-catalogue", "get-all-catalogues", "get-catalogue-by-id", "modifie-catalogue",
            "nouveau-tache", "get-all-taches", "get-tache-by-id", "modifie-tache",
            "nouveau-utilisateur", "get-utilisateur-by-id", "modifie-utilisateur", "modifie-utilisateur"
    };

    private Map<String, String[]> whiteListMap = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        whiteListMap.put("ROLE_ADMIN", adminMethodAllowed);
        whiteListMap.put("ROLE_EMPLOYE", modMethodAllowed);
        whiteListMap.put("ROLE_USER", userMethodAllowed);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.warn("Missing or invalid Authorization header");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing or invalid Authorization header");
        }

        final String jwtToken = authorizationHeader.substring(7);
        try {
            // Decode the payload
            final String[] tokenParts = jwtToken.split("\\.");
            final String encodedPayload = tokenParts[1];
            final byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedPayload);
            final String decodedPayload = new String(decodedBytes, StandardCharsets.UTF_8);

            // Map to object
            final ObjectMapper objectMapper = new ObjectMapper();
            final JwtPayload jwtPayload = objectMapper.readValue(decodedPayload, JwtPayload.class);

            // Log roles for debugging
            logger.info("Roles from JWT: {}", jwtPayload.getRoles());

            // Verification of permissions
            final String requestUri = httpServletRequest.getRequestURI();
            final String[] uriParts = requestUri.split("/");
            if (uriParts.length < 4) {
                logger.warn("Invalid URI structure: {}", requestUri);
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid URI structure");
            }

            boolean allowed = false;
            for (String role : jwtPayload.getRoles()) {
                final String[] allowedMethods = whiteListMap.getOrDefault(role, new String[]{});
                if (Arrays.asList(allowedMethods).contains(uriParts[3])) {
                    allowed = true;
                    break;
                }
            }

            if (allowed) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                logger.warn("Access forbidden for this role and method");
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access forbidden for this role and method");
            }

        } catch (Exception e) {
            logger.error("Invalid JWT token", e);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid JWT token", e);
        }
    }
}
