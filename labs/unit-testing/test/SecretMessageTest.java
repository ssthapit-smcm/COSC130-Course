import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests SecretMessage program, which encrypts and decrypts messages
 * 
 * @author Jessica Young Schmidt
 * @author [ADD STUDENT NAMES]
 */
public class SecretMessageTest {

    /**
     * Tests swapCharacter method - If first and last characters are letters, swap
     * first and last characters of message.
     */
    @Test
    public void testSwapCharacterEncryptHello() {
        assertEquals("oellH", SecretMessage.swapCharacter("Hello"),
                "Tests swapCharacter if first and last characters are letters");
    }

    // TODO: Add two additional test methods for swapCharacter. Consider: (1) first
    // character is digit and (2) no swaps needed

    /**
     * Tests moveCharacter method - Move character at index (length - 2) to the end
     * of the string
     */
    @Test
    public void testMoveCharacterEncryptHello() {
        assertEquals("oelHl", SecretMessage.moveCharacter("oellH"),
                "Tests moveCharacter for string of length 5");
    }

    // TODO: Add two additional test methods for moveCharacter. Consider various
    // valid lengths.

    /**
     * Tests swapSubstrings method - If length is odd and not divisible by three,
     * leave middle character as is and swap substrings before and after it.
     */
    @Test
    public void testSwapSubstringsEncryptHello() {
        assertEquals("Hlloe", SecretMessage.swapSubstrings("oelHl"),
                "Tests swapSubstrings if length is odd and not divisible by three");
    }

    // TODO: Add two additional test methods for swapSubstrings method. Consider:
    // (1) length is odd and divisible by three and (2) length is even

    /**
     * Tests encrypt method - where (1) first and last characters are letters and
     * (2) length is odd and not divisible by three
     */
    @Test
    public void testEncryptHello() {
        assertEquals("Hlloe", SecretMessage.encrypt("Hello"), "Tests encrypting Hello to Hlloe");
    }

    // TODO: Add two additional test methods for encrypt method. Consider using test
    // cases you wrote for your system tests. Also consider algorithm: If length of
    // message is less than three, output message.

    /**
     * Tests decrypt method - where (1) length is odd and not divisible by three and
     * (2) first and last characters are letters
     */
    @Test
    public void testDecryptHlloe() {
        assertEquals("Hello", SecretMessage.decrypt("Hlloe"), "Tests decrypting Hlloe to Hello");
    }

    // TODO: Add two additional test methods for decrypt method. Consider using test
    // cases you wrote for your system tests. Also consider algorithm: If length of
    // message is less than three, output message.

    /**
     * Tests moveCharacter method for invalid length
     */
    @Test
    public void testMoveCharacterInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> SecretMessage.moveCharacter("A"));
        assertEquals("Invalid string", exception.getMessage(),
                "Tests invalid length for moveCharacter method");
    }
}
