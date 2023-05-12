package cache.io;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Thiago
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class DataCache implements Serializable{
    
    @Id
    private String nameCache;
    private Map<Object, Object> datas;
}
