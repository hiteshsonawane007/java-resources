package com.mft.mftinterface.controller;

import com.mft.mftinterface.model.TerraformData;
import com.mft.mftinterface.util.GitHubUploader;
import com.mft.mftinterface.util.TerraformGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TerraformController {

    @GetMapping("/")
    public String showForm(Model model)
    {
        model.addAttribute("terraformData", new TerraformData());
        return  "terraform-form";
    }

    @PostMapping("/generate")
    public String generateTerraform(@ModelAttribute TerraformData terraformData)
    {
        String tfconfig = TerraformGenerator.generateConfig(terraformData);

        //Upload the Terraform Files to GitHub:
        GitHubUploader.uploadFilesToGitHub(tfconfig);

        return "redirect:/success";
    }
}
