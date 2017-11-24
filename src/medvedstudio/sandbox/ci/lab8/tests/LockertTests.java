package medvedstudio.sandbox.ci.lab8.tests;

import medvedstudio.sandbox.ci.lab8.src.Locker;
import medvedstudio.sandbox.ci.lab8.src.LockerLockedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockertTests {

    @Test
    public void check() throws LockerLockedException {

        Locker locker = new Locker();
        locker.unlock();

        //Set and get value
        locker.set(15);
        Assertions.assertEquals(15, locker.get());

        //Lock and change
        locker.lock();
        try {
            locker.set(3);
            Assertions.fail("Locker locked but value changed");
        } catch (LockerLockedException exception) {
            Assertions.assertEquals(15, locker.get());
        }

        //Unlock and change
        locker.unlock();
        locker.set(23);
        Assertions.assertEquals(23, locker.get());
    }
}
