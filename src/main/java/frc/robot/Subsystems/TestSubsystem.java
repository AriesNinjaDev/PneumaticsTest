package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestSubsystem extends SubsystemBase {
    Compressor compressor = new Compressor(30, PneumaticsModuleType.CTREPCM);
    Solenoid solenoid = new Solenoid(30, PneumaticsModuleType.CTREPCM, 0);
    public double waitTime = 1.0;

    public TestSubsystem() {
        solenoid.set(false);
    }

    public void toggleComp() {
        if (compressor.isEnabled()) {
            compressor.disable();
        } else {
            compressor.enableDigital();
        }
    }

    public void toggleSole() {
        if (solenoid.get()) {
            solenoid.set(false);
        } else {
            solenoid.set(true);
        }
    }

    public void closeSole() {
        solenoid.set(false);
    }

    public void increaseTimeSmall() {
        waitTime += 0.01;
        System.out.println(waitTime);
    }

    public void decreaseTimeSmall() {
        waitTime -= 0.01;
        System.out.println(waitTime);
    }

    public void increaseTimeBig() {
        waitTime += 0.1;
        System.out.println(waitTime);
    }

    public void decreaseTimeBig() {
        waitTime -= 0.1;
        System.out.println(waitTime);
    }
}
