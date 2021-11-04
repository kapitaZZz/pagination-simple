package dead.sec.kapitaz.paginate_pages.service;

import dead.sec.kapitaz.paginate_pages.model.User;
import dead.sec.kapitaz.paginate_pages.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public Page<User> fetchUsers(Integer page
            , Integer pageSize
            , String sortingField
            , String sortingDirection) {

        Sort sort = Sort.by(Sort.Direction.valueOf(sortingDirection), sortingField);
        Pageable pageable = PageRequest.of(page, pageSize, sort);

        return userRepository.findAll(pageable);
    }

    public void enrichDb() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setAge(i);
            user.setLogin("login" + i);
            user.setEmail("email" + i + "gmail.com");
            userList.add(user);
        }

        userRepository.saveAll(userList);
    }
}
