package demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.domain.model.ModelUserInfo;
import demo.domain.repository.RepositoryUserInfo;
import demo.requestdata.RequestUpdateData;
import demo.requestdata.RequestUserData;


@Controller
public class ControllerUserInfo {


    @Autowired
    RepositoryUserInfo repositoryUser;


    @GetMapping("/") //初期html (hello.html)
    public String hello(Model model) {
    	//DB一覧
    	List<ModelUserInfo> userModel = repositoryUser.selectByExample();
        model.addAttribute("dataUserInfo", userModel);
        //文字呼び出し
        model.addAttribute("outContoroller", "Hello, World!");
        //新規入力画面
        model.addAttribute("requestData", new RequestUserData());

        return "hello";//(ここで戻り先を指定、表示しているhtml)
    }

    // 詳細ボタンから飛ぶ
    // hello.html -> view.html
    //この中は表示だけ（持ってきたデータを表示）
    // <a th:href="@{/{id}(id=*{id})}">詳細+編集</a>
    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model) {

    	ModelUserInfo user = repositoryUser.selectByPrimaryKey(id);
    	model.addAttribute("userRequest", user);

    	ModelUserInfo updataUser = repositoryUser.selectByPrimaryKey(id);
        model.addAttribute("updateRequestData", updataUser);

    	return "view";
    }


    //登録ボタン呼び出し
    //hello.html から呼び出し
    //<form th:action="@{/create}" th:object="${requestData}" method="post">
    @RequestMapping(value="/create")
    public String create(@ModelAttribute @Valid RequestUserData insertRequest, Model model) {
    	//新規登録処理（DBに入れるために変換していれる）
		ModelUserInfo newData = new ModelUserInfo();
		newData.setName(insertRequest.getName());
		newData.setGender(insertRequest.getGender());
    	repositoryUser.insert(newData);
    	return "redirect:";
    }


    //編集上書きボタン呼び出し
    //view.html から呼び出し
    //<form th:action="@{/updata}" th:object="${updateRequestData}" method="post">
    @RequestMapping(value="/updata")
    public String updata(@ModelAttribute @Valid RequestUpdateData updataRequest, Model model) {
    	//新規登録処理（DBに入れるために変換していれる）
		ModelUserInfo updataUserData = new ModelUserInfo();
		updataUserData.setId(updataRequest .getId());
		updataUserData.setName(updataRequest.getName());
		updataUserData.setGender(updataRequest.getGender());

        repositoryUser.updateByPrimaryKey(updataUserData);
    	return "redirect:";
    }


    @RequestMapping("/delete{id}")
    public String delete(@PathVariable ("id") Integer id, Model model) {
    	repositoryUser.deleteByPrimaryKey(id);
    	return "redirect:";
    }
}
