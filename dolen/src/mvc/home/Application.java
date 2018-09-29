package mvc.home;

import mvc.home.controller.Controller;
import mvc.home.model.Model;
import mvc.home.view.View;

public class Application {
    private Model model;
    private View view;
    private Controller controller;
    
    public Application () {
        /**
         * 1. 모델의 데이터 변경은 컨트롤러만 수행하므로 컨트롤러만 알고 있는다.
         * 2. 뷰는 자신을 업데이트할때 모델의 데이터를 받아야하므로 모델을 알고 있는다.
         * 3. 컨트롤러는 모델을 변경해야하고, 뷰의 이벤트를 등록해야하므로 둘다 알고 있어야 한다. 
         * 
         * - 뷰가 모델을 알고있어야 하는가 -- 알고있는 편이 좋다. (코딩이 여러모로 편해진다.)
         *  - 뷰도 알고, 컨트롤러도 모델을 알면 상호참조 되는것이 아닌가? -- 모델이 다른 누구도 알고 있지 않기 때문에 상호참조가 아니다.
         *  - 다만 데이터를 뷰에서 변경하는 짓은 하지 마시라.
         */
        this.model = new Model();
        this.view = new View(model);
        this.controller = new Controller(model, view);
    }
    
    public static void main(String[] args) {
        new Application();
    }
}
