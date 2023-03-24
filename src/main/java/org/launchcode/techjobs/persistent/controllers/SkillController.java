package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


//Create a SkillController class and replicate the steps you followed above for EmployerController.
// The new controller should have the methods, index, displayAddSkillForm, processAddSkillForm, and displayViewSkill.
// These methods should behave exactly as the corresponding methods in EmployerController.
// The relevant templates have already been created for you.
//At this point, uncomment all remaining methods in TestTaskTwo, if you have not done so already.
// You’ll need to add an import statement for the new controller to the test file.

@Controller
@RequestMapping("skill")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "All Skills");
        model.addAttribute("skills", skillRepository.findAll());
        return "skill/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("title","All Skills");
        model.addAttribute(new Skill());
        return "skill/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skill/add";
        }
        skillRepository.save(newSkill);
        model.addAttribute("skill", skillRepository.findAll());
        return "redirect:";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("employer", skill);
            return "skill/view";
        } else {
            return "redirect:../";
        }
    }

}
