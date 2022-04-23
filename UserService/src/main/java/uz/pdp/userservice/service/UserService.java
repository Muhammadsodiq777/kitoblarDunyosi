package uz.pdp.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.userservice.entity.UserEntity;
import uz.pdp.userservice.payload.DTOs.UserDTO;
import uz.pdp.userservice.payload.responce.ApiResponce;
import uz.pdp.userservice.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public ApiResponce addUser(UserDTO userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());

        if (existsByPhoneNumber) {

            return new ApiResponce("not exiist", false);
        }

        UserEntity customer = new UserEntity();
        userDetails(customer, userDto);
        userRepository.save(customer);
        return new ApiResponce("hhjh", true, customer);
    }

    public void userDetails(UserEntity user, UserDTO userDto) {
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
    }

    public ApiResponce editUser(UserDTO userDto, Long id) {

        boolean byPhoneNumberAndIdNot = userRepository.existsByPhoneNumberAndIdNot(userDto.getPhoneNumber(), id);
        if (byPhoneNumberAndIdNot) {
            return new ApiResponce("no this cusytomer", false);
        }
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return new ApiResponce("not found", false);

            UserEntity user = optionalUser.get();
            userDetails(user, userDto);
            UserEntity savedUser = userRepository.save(user);
            return new ApiResponce("hghgfhgfhh", true, savedUser);
        }

        public ApiResponce deleteUser (Long id){
            userRepository.deleteById(id);
            return new ApiResponce("deleted", true);
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
