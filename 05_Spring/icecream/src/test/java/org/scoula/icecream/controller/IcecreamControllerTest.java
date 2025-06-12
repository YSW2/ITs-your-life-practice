package org.scoula.icecream.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.service.IcecreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class
})
@Log4j2
class IcecreamControllerTest {
    @Autowired
    IcecreamService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void newPost() throws Exception {
        String viewName = mockMvc.perform(MockMvcRequestBuilders.post("/icecream/new")
                        .param("name", "새 아이스크림")
                        .param("flavor", "새로운 맛")
                        .param("price", "10000"))
                // ResultActions 리턴
                .andReturn()        // MvcResult 리턴
                .getModelAndView()    // ModelAndView 리턴
                .getViewName();
        log.info("이동되는 뷰: " + viewName);
    }

    @Test
    void listGet() throws Exception {
        ModelAndView modelView = mockMvc.perform(MockMvcRequestBuilders.get("/icecream/list"))    // ResultActions 리턴
                .andReturn()                // MvcResult 리턴
                .getModelAndView();   // ModelAndView 리턴
        List<IcecreamDTO> list = (List<IcecreamDTO>) modelView.getModelMap().get("list");

        log.info("뷰 이름: " + modelView.getViewName());
        log.info("조회된 아이스크림의 수: " + list.size());

        for (IcecreamDTO icecream : list) {
            log.info(icecream);
        }
    }

    @Test
    void deletePost() throws Exception {
        // 삭제전 데이터베이스에 게시물 번호 확인할 것
        ModelAndView modelView = mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/icecream/delete")
                                .param("no", "2")
                )
                .andReturn()
                .getModelAndView();

        log.info("✅ 이동된 뷰 이름: " + modelView.getViewName());
        log.info("삭제 성공 여부: " + modelView.getModelMap().getAttribute("result"));
    }

}