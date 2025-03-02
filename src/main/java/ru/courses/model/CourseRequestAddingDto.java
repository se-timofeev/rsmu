package ru.courses.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.LocalDateTimeConverter;

import javax.persistence.Convert;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestAddingDto {

    @ApiModelProperty(required = true, example = "3 курс")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @ApiModelProperty(required = true, example = "2022-10-14T01:00:00")
    @Convert (converter = LocalDateTimeConverter.class)
    private LocalDateTime start_date;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @ApiModelProperty(required = true, example = "2022-10-20T01:00:00")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Convert (converter = LocalDateTimeConverter.class)
    private LocalDateTime end_date;

    private Boolean isActive;

}
