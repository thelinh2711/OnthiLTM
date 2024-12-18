package WSClient;

import java.util.Collections;
import java.util.List;
import vn.medianews.CharacterService_Service;
import vn.medianews.CharacterService;

public class WSCharcter486 {
    public static void main(String[] args) throws Exception {
        CharacterService_Service ccs = new CharacterService_Service();
        CharacterService cs = ccs.getCharacterServicePort();

        List<Integer> list = cs.requestCharacter("B21DCCN486", "M3iI5Y43");
        Collections.sort(list);

        cs.submitCharacterCharArray("B21DCCN486", "M3iI5Y43", list);
    }
}
