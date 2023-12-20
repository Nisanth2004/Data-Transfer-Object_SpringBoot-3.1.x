package nisanthdto.DTO.Demo.dto;

import lombok.Data;

@Data
public class UserLocationDTO
{
    // contains details of user and location
    private long userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;


}
