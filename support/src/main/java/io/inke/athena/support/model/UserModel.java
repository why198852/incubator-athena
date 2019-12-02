package io.inke.athena.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserModel {

    private Integer id;
    private String userName;
    private String password;

    private List<AppmetaModel> appmetas; // appmeta list

}
