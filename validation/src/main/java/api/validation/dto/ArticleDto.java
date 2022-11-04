package api.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ArticleDto {

    @NotNull
    @Length(max = 20)
    private String title;

    @NotNull
    private String content;

    @Email
    private String email;
}
