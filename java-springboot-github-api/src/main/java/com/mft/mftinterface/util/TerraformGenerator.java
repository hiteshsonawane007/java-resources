package com.mft.mftinterface.util;

import com.mft.mftinterface.model.TerraformData;

public class TerraformGenerator {

    public static String generateConfig(TerraformData terraformData)
    {
        //Generate Terraform Configuration based on TerraformData

        //Return the generated configurations as a string
        return "# Sample Terraform configuration\n" +
                "resource \"example_resource\" {\n " +
                " name = \"" + terraformData.getResourceName() + "\"\n" +
                "// Add more configurations here\n" +
                "}\n";
    }
}
