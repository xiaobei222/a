package com.anydoortrip.anydoortrip.apps.utlis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnyDoorException extends RuntimeException {

        private  int code;
        private  String msg;




}
