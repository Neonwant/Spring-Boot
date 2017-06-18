package ua.springboot.web;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.springboot.model.StackoverflowWebsite;
import ua.springboot.service.StackoverflowService;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {
    @Mock
    private StackoverflowService stackoverflowService;
    @InjectMocks
    StackOverflowController sut;

    @Test
    public void testGetListOfProviders() throws Exception {
        //prepare
        when(stackoverflowService.findAll()).thenReturn(ImmutableList.of());
        //testing
        List<StackoverflowWebsite> listOfProviders = sut.getListOfProviders();
        //validate
        verify(stackoverflowService).findAll();
    }

}