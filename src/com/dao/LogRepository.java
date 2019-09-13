package com.dao;

import com.business.Product;
import com.commons.enums.EnumDataRepositoryPath;

import java.io.IOException;
import java.util.Arrays;

public class LogRepository {
    public static void registerLog(String log) throws IOException {
        RepositoryActions actions = new RepositoryActions();
        actions.writeFile(
                EnumDataRepositoryPath.Log.getPath(),
                log
        );
    }
}
