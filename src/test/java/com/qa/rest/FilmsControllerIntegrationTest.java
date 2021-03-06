package com.qa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.DeluxeScreen;
import com.qa.domain.Films;
import com.qa.domain.StandardScreen;
import com.qa.dto.FilmsDTO;
import com.qa.repo.FilmsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilmsControllerIntegrationTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private FilmsRepository repository;

    @Autowired
    private ModelMapper mapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Films testFilms;

    private Films testFilmsWithID;

    private long testID;

    private List<StandardScreen> standardScreen;

    private List<DeluxeScreen> deluxeScreen;

    private FilmsDTO filmsDTO;

    private FilmsDTO mapToDTO(Films films){
        return this.mapper.map(films, FilmsDTO.class);
    }

    @Before
    public void setUpForTests() {
        this.repository.deleteAll();
        this.standardScreen = new ArrayList<>();
        this.deluxeScreen = new ArrayList<>();
        this.testFilms = new Films("Title", "classification", true,
                "AAA", true, standardScreen, deluxeScreen);
        this.testFilmsWithID = this.repository.save(testFilms);
        this.testID = testFilmsWithID.getFilmsID();
        this.filmsDTO = this.mapToDTO(testFilmsWithID);
    }

    @Test
    public void getAllFilmsTest() throws Exception {
        List<FilmsDTO> filmsDTOList = new ArrayList<>();
        filmsDTOList.add(filmsDTO);
        String jsonContent = this.mock.perform(request(HttpMethod.GET, "/getAllFilms")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        assertEquals(jsonContent, this.objectMapper.writeValueAsString(filmsDTOList));
    }

    @Test
    public void createFilmsTest() throws Exception {
        String result = this.mock.perform(request(HttpMethod.POST, "/createFilms").contentType(
                MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(testFilms))
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn().getResponse()
                .getContentAsString();
        assertEquals(result, this.objectMapper.writeValueAsString(filmsDTO));
    }

    @Test
    public void getFilmsByIDTest() throws Exception {
        String jsonContent = this.mock.perform(request(HttpMethod.GET, "/getFilmsById/" + this.testID)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        assertEquals(jsonContent, this.objectMapper.writeValueAsString(filmsDTO));
    }

    @Test
    public void getFilmsStandardScreenings() throws  Exception {
        String jsonContent = this.mock.perform(request(HttpMethod.GET, "/getFilmsStandardScreenings/" + this.testID)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        assertEquals(jsonContent, this.objectMapper.writeValueAsString(filmsDTO.getStandardScreen()));
    }

    @Test
    public void getFilmsDeluxeScreenings() throws  Exception {
        String jsonContent = this.mock.perform(request(HttpMethod.GET, "/getFilmsDeluxeScreenings/" + this.testID)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        assertEquals(jsonContent, this.objectMapper.writeValueAsString(filmsDTO.getDeluxeScreen()));
    }

    @Test
    public void deleteFilmsTest() throws Exception {
        this.mock.perform(request(HttpMethod.DELETE, "/deleteFilms/" + this.testID))
                .andExpect(status().isNoContent());
    }
}
