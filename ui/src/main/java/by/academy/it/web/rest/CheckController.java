package by.academy.it.web.rest;

import by.academy.it.dto.CheckLoginDto;
import by.academy.it.service.AjaxCheckService;
import by.academy.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check")
public class CheckController {
    private String existsMessage;

    @Autowired
    private UserService userService;

    @Autowired
    private AjaxCheckService ajaxCheckService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<CheckLoginDto> checkLogin(@RequestParam String login) {
        CheckLoginDto checkLoginDto = ajaxCheckService.ajaxCheckFieldInDatabase(userService, login,
                true);
        return new ResponseEntity<>(checkLoginDto, HttpStatus.OK);
    }

    @GetMapping(value = "/checkURL")
    @ResponseBody
    public ResponseEntity<CheckLoginDto> checkURL(@RequestParam String link) {
        CheckLoginDto checkLoginDto = ajaxCheckService.ajaxCheckFieldInDatabase(userService, link,
                false);
        return new ResponseEntity<>(checkLoginDto, HttpStatus.OK);
    }
}