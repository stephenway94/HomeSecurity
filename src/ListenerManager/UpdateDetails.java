/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListenerManager;

import java.util.HashMap;

/**
 *
 * @author StephenRobert
 */
public class UpdateDetails {

    public UpdateDetails(HashMap<Integer, Integer> details, int id) {
        int tmp = details.get(id);
        if (tmp == 1) {
            tmp = 0;
            new UpdateLogIn(id, tmp);
        } else {
            tmp = 1;
            new UpdateLogIn(id, tmp);
        }

    }

}
