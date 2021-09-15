package br.com.quarkus.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.LocalDateTime.ofInstant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageError implements Serializable {

    private static final long serialVersionUID = -5391117740628905270L;

    private String message;
    private final String instant = ofInstant(Instant.now(), ZoneId.systemDefault())
            .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
}
