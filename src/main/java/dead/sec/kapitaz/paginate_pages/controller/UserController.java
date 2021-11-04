package dead.sec.kapitaz.paginate_pages.controller;

import dead.sec.kapitaz.paginate_pages.model.User;
import dead.sec.kapitaz.paginate_pages.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/populate")
    public String populate() {
        userService.enrichDb();
        return "OK";
    }

    @GetMapping("/getUsers")
    public Page<User> getUsers(@RequestParam Integer page, @RequestParam Integer size,
                               @RequestParam String sortingField,
                               @RequestParam String sortingDirection) {
        log.info("handling users request: {}, {}, {}, {}", page, size, sortingField, sortingDirection);
        return userService.fetchUsers(page, size, sortingField, sortingDirection);
    }

}
