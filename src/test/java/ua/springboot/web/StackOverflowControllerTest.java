package ua.springboot.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.springboot.model.StackoverflowWebsite;
import ua.springboot.service.StackoverflowService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {
    @Mock
    private StackoverflowService stackoverflowService;
    @InjectMocks
    StackOverflowController sut;

    @Test
    public void testGetListOfProviders() throws Exception {
        List<StackoverflowWebsite> listOfProviders = sut.getListOfProviders();
    }

}