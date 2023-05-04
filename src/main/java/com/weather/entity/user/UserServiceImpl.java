package com.weather.entity.user;

import com.weather.entity.city.City;
import com.weather.entity.city.CityRepository;
import com.weather.entity.weather.Weather;
import com.weather.entity.weather.WeatherRepository;
import com.weather.enumeration.ResponseStatus;
import com.weather.enumeration.RoleName;
import com.weather.enumeration.Status;
import com.weather.exception.RestException;
import com.weather.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final CityRepository cityRepository;
    private final WeatherRepository weatherRepository;


    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RestException(ResponseStatus.USER_NOT_FOUND));
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new RestException(ResponseStatus.USER_NOT_FOUND)));
    }

    @Override
    public UserResponse create(UserPayload payload) {
        User user = new User();
        extracted(payload);
        save(payload, user);
        return userMapper.toDto(user);
    }

    @Override
    public UserResponse update(Long id, UserPayload payload) {
        User user = getById(id);
        extracted(payload);
        save(payload, user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Object, Object> generationToken(UserPassword password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        password.getUsername(),
                        password.getPassword()));
        User user = userRepository.findByUsername(password.getUsername());
        if (user == null) {
            throw new RestException(ResponseStatus.USER_NOT_FOUND);
        }

        String token = tokenProvider.createToken(user.getUsername(), user.getRole());
        Map<Object, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("role", user.getRole().name());
        return map;
    }

    private void extracted(UserPayload payload) {
        boolean checkPassword = !checkPassword(payload.getPassword());
        if (checkPassword) {
            throw new RestException(ResponseStatus.USER_PASSWORD_LESS);
        }
        if (Boolean.TRUE.equals(checkUsername(payload.getUsername()))) {
            throw new RestException(ResponseStatus.USER_ALREADY_EXIST);
        }
    }

    private void save(UserPayload payload, User user) {
        City city = new City();
        Weather weather = new Weather();
        user.setUsername(payload.getUsername());
        user.setRole(RoleName.USER);
        user.setEmail(payload.getEmail());
        user.setFirstname(payload.getFirstname());
        user.setLastname(payload.getLastname());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user.setStatus(Status.ACTIVE);
        city.setParentId(payload.getSubscribedCities().getParentId());
        city.setName(payload.getSubscribedCities().getName());
        city.setStatus(Status.ACTIVE);
        weather.setWindSpeed(payload.getSubscribedCities().getWeather().getWindSpeed());
        weather.setTemperature(payload.getSubscribedCities().getWeather().getTemperature());
        weather.setCityId(city.getId());
        weather.setStatus(Status.ACTIVE);
        weatherRepository.save(weather);
        cityRepository.save(city);
        userRepository.save(user);
    }

    public Boolean checkUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

    public Boolean checkPassword(String password) {
        return password.length() >= 4;
    }
}
