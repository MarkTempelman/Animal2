package Animals;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservor {
    private String _name;
    private LocalDateTime _reservedAt;

    public Reservor(String name, LocalDateTime reservedAt){
        _name = name;
        _reservedAt = reservedAt;
    }

    public String getName(){
        return _name;
    }

    public LocalDateTime getReservedAt(){
        return _reservedAt;
    }
}
