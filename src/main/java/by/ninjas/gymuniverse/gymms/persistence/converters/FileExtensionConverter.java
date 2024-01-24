package by.ninjas.gymuniverse.gymms.persistence.converters;

import by.ninjas.gymuniverse.gymms.persistence.enums.FileExtension;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FileExtensionConverter implements AttributeConverter<FileExtension, String> {

    @Override
    public String convertToDatabaseColumn(FileExtension attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public FileExtension convertToEntityAttribute(String dbData) {
        return dbData == null ? null : FileExtension.fromValue(dbData).orElse(null);
    }
}
