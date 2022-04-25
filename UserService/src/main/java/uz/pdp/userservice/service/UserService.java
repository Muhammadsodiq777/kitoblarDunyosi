package uz.pdp.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.feinclient.book.dto.BookDTO;
import uz.pdp.feinclient.book.fein_client.GetAllBook;
import uz.pdp.userservice.entity.UserEntity;
import uz.pdp.userservice.payload.responce.ApiResponse;
import uz.pdp.userservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final GetAllBook getAllBook;
    public List<BookDTO> getAllBooks() {
        List<BookDTO> allBook = getAllBook.getAllBook();
        return allBook;
    }
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public ApiResponse addUser(UserEntity userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());

        if (existsByPhoneNumber) {

            return new ApiResponse("not exiist", false);
        }

        UserEntity customer = new UserEntity();
        userDetails(customer, userDto);
        userRepository.save(customer);
        return new ApiResponse("hhjh", true, customer);
    }

    public void userDetails(UserEntity user, UserEntity userDto) {
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
    }

    public ApiResponse editUser(UserEntity userDto, Long id) {

        boolean byPhoneNumberAndIdNot = userRepository.existsByPhoneNumberAndIdNot(userDto.getPhoneNumber(), id);
        if (byPhoneNumberAndIdNot) {
            return new ApiResponse("no this cusytomer", false);
        }
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return new ApiResponse("not found", false);

            UserEntity user = optionalUser.get();
            userDetails(user, userDto);
            UserEntity savedUser = userRepository.save(user);
            return new ApiResponse("hghgfhgfhh", true, savedUser);
        }

        public ApiResponse deleteUser (Long id){
            userRepository.deleteById(id);
            return new ApiResponse("deleted", true);
        }

        @Override
        public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
            return userRepository.findByPhoneNumber(username).orElseThrow(() -> new IllegalStateException("User not found"));
        }

        //currentUser
        public static UserEntity getCurrentUser () {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return (UserEntity) principal;
        }
    }
