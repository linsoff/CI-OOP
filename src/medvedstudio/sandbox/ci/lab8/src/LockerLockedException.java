package medvedstudio.sandbox.ci.lab8.src;

import java.rmi.AccessException;

public class LockerLockedException extends AccessException {

    public LockerLockedException (){
        super("Container is locked. You can't set value.");
    }
}
