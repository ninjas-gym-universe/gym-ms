package by.ninjas.gymuniverse.gymms.persistence.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum FileExtension {
    //photo
    JPG("jpg"),
    JPEG("jpeg"),
    PNG("png"),
    GIF("gif"),

    //video
    AVI("avi"),
    MP4("mp4"),
    MPEG4("mpeg4");

    private static final Map<String, FileExtension> MAP_BY_VALUE = Stream.of(values()).collect(Collectors.toMap(FileExtension::getValue, Function.identity()));

    private final String value;

    public static Optional<FileExtension> fromValue(String value) {
        return Optional.ofNullable(MAP_BY_VALUE.get(value));
    }

}
