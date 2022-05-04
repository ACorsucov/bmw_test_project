package com.testproject.testproject.domain.model.mapper;

import com.testproject.testproject.domain.model.AddressDto;
import com.testproject.testproject.domain.model.CompanyDto;
import com.testproject.testproject.domain.model.GeoDto;
import com.testproject.testproject.domain.model.UserDto;
import com.testproject.testproject.persitence.model.User;

public class UserMapper {

    public static User fromUserDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .userName(userDto.getUserName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .website(userDto.getWebsite())
                .street(userDto.getAddress().getStreet())
                .suite(userDto.getAddress().getSuite())
                .city(userDto.getAddress().getCity())
                .zipCode(userDto.getAddress().getZipcode())
                .lat(userDto.getAddress().getGeo().getLat())
                .lng(userDto.getAddress().getGeo().getLng())
                .companyName(userDto.getCompany().getName())
                .companyCatchPhrase(userDto.getCompany().getCatchPhrase())
                .companyBs(userDto.getCompany().getBs())
                .build();
    }

    public static UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .website(user.getWebsite())
                .address(AddressDto.builder()
                        .street(user.getStreet())
                        .suite(user.getSuite())
                        .city(user.getCity())
                        .zipcode(user.getZipCode())
                        .geo(GeoDto.builder()
                                .lat(user.getLat())
                                .lng(user.getLng())
                                .build())
                        .build())
                .company(CompanyDto.builder()
                        .name(user.getCompanyName())
                        .catchPhrase(user.getCompanyCatchPhrase())
                        .bs(user.getCompanyBs())
                        .build())
                .build();
    }
}
