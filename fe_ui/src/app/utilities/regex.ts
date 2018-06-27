export class Regex {
    /**
     * At least 8 letters. (Have special, upper, lower, number)
     */
    public static PASSWORD_DIFFICULTY = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$$";

    /**
     * Phone number have length from 10 to 11 number. (Start with 0)
     */
    public static PHONE_NUMBER = "^0[0-9]{9,10}$";
}