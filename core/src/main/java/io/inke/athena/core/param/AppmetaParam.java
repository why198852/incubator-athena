package io.inke.athena.core.param;

import io.inke.athena.core.validate.appmeta.AppmetaNameExistsValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppmetaParam {

    @NotEmpty(message = "appmeta name must not null or empty")
    @AppmetaNameExistsValidate
    private String name;

}
