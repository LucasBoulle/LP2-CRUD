package com.business;

import java.io.IOException;

public abstract class RegistrableObject {
    public abstract void register(RegistrableObject obj) throws IOException;
}
