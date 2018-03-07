package com.example.exam5;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class Exam5RestController {
    /**
     * {@code /get_dummy_json_data}ディレクトリに対する処理を行います。
     *
     * @return 文字列
     */
    @RequestMapping(value = "/get_dummy_json_data", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map home() {
        return Collections.singletonMap("response", "Star wars.");
    }
}
