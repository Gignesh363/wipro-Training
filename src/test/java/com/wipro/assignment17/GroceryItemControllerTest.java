package com.wipro.assignment17;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.assignment17.controller.GroceryItemController;
import com.wipro.assignment17.entity.GroceryItem;
import com.wipro.assignment17.service.GroceryItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Test
    void testGetAllItems() throws Exception {
        Mockito.when(service.getAllItems()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/grocery"))
                .andExpect(status().isOk());
    }
}
