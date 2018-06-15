/*

 */
package byui.cit260.oregonTrail.control;

import byui.cit260.oregonTrail.exceptions.HuntControlException;

/**
 *
 * @author J.R. Basham
 */
public class HuntControl {
    
    public int calcHuntSuccess(int charHuntingSkill, int wildLifeAmount, float charStamina) throws HuntControlException {
        float amountFood;
        if ((charHuntingSkill <= 0) || (charHuntingSkill > 10)){ 
               throw new HuntControlException("Your Hunting skill is less than 0 or greater than 10. Press Q to go back.");
        } else if (wildLifeAmount < 10) {
               throw new HuntControlException("Wildlife is less than 10 animals. Press Q to go back.");
        } else if ((charStamina <= 0) || (charStamina > 1)){
               throw new HuntControlException("Characters stamina is less than 0. Press Q to go back.");
        } else {
            float newWildLifeAmount = wildLifeAmount * charStamina;  
            newWildLifeAmount = newWildLifeAmount / charHuntingSkill;
            amountFood = newWildLifeAmount * 5;
            amountFood = Math.round(amountFood);
        }
        return (int) amountFood;
    }
    
}
