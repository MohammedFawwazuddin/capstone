// package com.project.capstone;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.project.capstone.Entity.Quote;
// import com.project.capstone.repository.QuoteRepository;
// import com.project.capstone.repository.UserRepository;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class CapstoneApplicationTests {

//     @Autowired
//     private MockMvc mockMvc;

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private QuoteRepository quoteRepository;

//     // @Test
//     // public void testRegisterUser() throws Exception {
//     //     User user = new User();
//     //     user.setName("testUser");
//     //     user.setPassword("password");

//     //     mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
//     //             .contentType(MediaType.APPLICATION_JSON)
//     //             .content(asJsonString(user)))
//     //             .andExpect(status().isOk());
//     // }

//     @Test
//     public void testStoreQuote() throws Exception {
//         Quote quote = new Quote();
//         mockMvc.perform(MockMvcRequestBuilders.post("/api/selectpage")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(asJsonString(quote)))
//                 .andExpect(status().isCreated());
//     }

//     @Test
//     public void testGetLocation() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/api/location"))
//                 .andExpect(status().isOk());
//     }

//     private static String asJsonString(Object obj) {
//         try {
//             return new ObjectMapper().writeValueAsString(obj);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
// }
