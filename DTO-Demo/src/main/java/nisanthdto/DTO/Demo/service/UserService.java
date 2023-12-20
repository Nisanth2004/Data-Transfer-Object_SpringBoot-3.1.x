package nisanthdto.DTO.Demo.service;

import nisanthdto.DTO.Demo.dto.UserLocationDTO;
import nisanthdto.DTO.Demo.model.User;
import nisanthdto.DTO.Demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<UserLocationDTO> getAllUsersLocaion()
    {
      return userRepository.findAll()
              .stream()
              .map(this::convertEntityToDto)
              .collect(Collectors.toList());
    }


    // convert user object into userlocationdto


//    private UserLocationDTO convertEntityToDto(User user)
//    {
//        UserLocationDTO userLocationDTO=new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//        return userLocationDTO;
//
//    }

    private UserLocationDTO convertEntityToDto(User user)
    {
        // matching strategy to LOOSE to make it easier to for the library to locate and match properties

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO=new UserLocationDTO();
        userLocationDTO=modelMapper.map(user,UserLocationDTO.class);
        return userLocationDTO;

    }


    private User convertDtoToEntity(UserLocationDTO userLocationDTO)
    {
        // matching strategy to LOOSE to make it easier to for the library to locate and match properties

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        User user=new User();
        user=modelMapper.map(userLocationDTO,User.class);   //(source,desrination)
        return user;
    }
}
