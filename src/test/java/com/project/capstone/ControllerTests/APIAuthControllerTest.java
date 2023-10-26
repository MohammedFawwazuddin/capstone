// package com.project.capstone.ControllerTests;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.oauth2.jwt.Jwt;
// import org.springframework.security.oauth2.jwt.JwtClaimsSet;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

// import com.project.capstone.business.LoginBody;
// import com.project.capstone.business.TokenDTO;
// import com.project.capstone.controller.APIAuthController;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.time.Instant;
// import java.util.ArrayList;
// import java.util.List;

// public class APIAuthControllerTest {

//     @InjectMocks
//     private APIAuthController apiAuthController;

//     @Mock
//     private JwtEncoder jwtEncoder;

//     @Mock
//     private AuthenticationManager authenticationManager;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     public void testToken() {
//         // Mocked input data
//         LoginBody loginBody = new LoginBody();
//         loginBody.setUsername("testUser");
//         loginBody.setPassword("testPassword");

//         // Mocked authorities
//         List<GrantedAuthority> authorities = new ArrayList<>();
//         authorities.add(() -> "ROLE_USER"); // Mocked authority

//         // Mocked authentication result
//         Authentication mockedAuthentication = new UsernamePasswordAuthenticationToken("testUser", "testPassword", authorities);

//         // Mocked JWT claims
//         JwtClaimsSet mockedClaims = JwtClaimsSet.builder()
//             .issuer("self")
//             .issuedAt(Instant.ofEpochSecond(0))
//             .expiresAt(Instant.ofEpochSecond(3600))
//             .subject("testUser")
//             .claim("scope", "ROLE_USER")
//             .build();

//         // Mock behavior
//         Mockito.when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class)))
//             .thenReturn(mockedAuthentication);

//         Mockito.when(jwtEncoder.encode(Mockito.any())).thenAnswer(invocation -> {
//             JwtEncoderParameters parameters = invocation.getArgument(0);
//             JwtClaimsSet claims = parameters.getClaims();
//             return Jwt.withTokenValue("tokenValue")
//                     .header("alg", "none")
//                     .claim("iss", claims.getIssuer())
//                     .claim("sub", claims.getSubject())
//                     .claim("iat", claims.getIssuedAt().getEpochSecond())
//                     .claim("exp", claims.getExpiresAt().getEpochSecond())
//                     .claim("scope", claims.getClaimAsString("scope"))
//                     .build();
//         });

//         // Call the controller method
//         TokenDTO tokenDTO = apiAuthController.token(loginBody);

//         // Assertions
//         Mockito.verify(authenticationManager).authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class));
//         Mockito.verify(jwtEncoder).encode(Mockito.any());
//         assertEquals("tokenValue", tokenDTO.getToken());
//     }
// }
