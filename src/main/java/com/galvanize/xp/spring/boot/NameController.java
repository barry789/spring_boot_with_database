package com.galvanize.xp.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class NameController {
    private NameRepository nameRepository;

    @Autowired
    NameController(NameRepository nameRepository){
        this.nameRepository = nameRepository;
    }

    @RequestMapping("/*")
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, HttpServletRequest request) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(request);
        nameRepository.save(new Name(name, dateFormat.format(date), request.getContextPath()));

        List<Name> nameListSorted = nameRepository.findAll(new Sort(Sort.Direction.DESC, "timestamp"));

        model.addAttribute("name", nameListSorted.get(0).getName());
        model.addAttribute("timestamp", nameListSorted.get(0).getTimestamp());

        model.addAttribute("names", nameListSorted);
        return "name/index";
    }
}
