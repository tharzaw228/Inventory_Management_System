package spring.repository;

import org.springframework.stereotype.Repository;
import spring.dto.CategoryDto;
import spring.dto.LocationDto;
import spring.model.Location;
import spring.utils.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationRepository {

    public int insertLocation(LocationDto locationDto) {

        int i = 0;
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO location(location_name,address) VALUES (?,?)");
            preparedStatement.setString(1, locationDto.getLocationName());
            preparedStatement.setString(2, locationDto.getAddress());

            i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Location insert : " + e.getMessage());
        }
        return i;
    }

    public List<LocationDto> showAllLocations() {
        List<LocationDto> locationList = new ArrayList<LocationDto>();
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM location");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LocationDto locationDto = new LocationDto();
                locationDto.setId(resultSet.getLong("id"));
                locationDto.setLocationName(resultSet.getString("location_name"));
                locationDto.setAddress(resultSet.getString("address"));
                locationList.add(locationDto);
            }

        } catch (SQLException e) {
            System.out.println("Location list : " + e.getMessage());
        }

        return locationList;
    }

    public LocationDto showLocation(LocationDto dto) {

        LocationDto locationDto = null;
        Connection connection = ConnectionClass.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM location WHERE id = ?");
            preparedStatement.setLong(1, dto.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                locationDto = new LocationDto();
                locationDto.setId(resultSet.getLong("id"));
                locationDto.setLocationName(resultSet.getString("location_name"));
                locationDto.setAddress(resultSet.getString("address"));
            }

        } catch (SQLException e) {
            System.out.println("Select one location: " + e.getMessage());
        }

        return locationDto;
    }

    public int updateLocation(LocationDto dto) {
        int i = 0;
        Connection connection = ConnectionClass.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE location SET location_name=?, address=? WHERE id = ?");
            preparedStatement.setString(1, dto.getLocationName());
            preparedStatement.setString(2, dto.getAddress());
            preparedStatement.setLong(3, dto.getId());

            i = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Update location :" + e.getMessage());
        }

        return i;
    }

    public int deleteLocation(Long id) {
        return 0;
    }
    
    public LocationDto getLocationById(int id) {
        LocationDto locationDTO = null;
        Connection con = ConnectionClass.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM location WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                locationDTO = new LocationDto();
                locationDTO.setId(rs.getLong("id"));
                locationDTO.setLocationName(rs.getString("location_name"));
                locationDTO.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("Get Location By Id: " + e.getMessage());
        }
        return locationDTO;
    }
}
