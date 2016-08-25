package org.openprocurement.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;

public class CustomDeserializationContext extends DefaultDeserializationContext {
    final static Logger logger = LoggerFactory.getLogger(CustomDeserializationContext.class);

    public CustomDeserializationContext(DeserializerFactory df) {
        super(df, null);
    }

    protected CustomDeserializationContext(CustomDeserializationContext src,
                   DeserializationConfig config, JsonParser jp, InjectableValues values) {
        super(src, config, jp, values);
    }

    protected CustomDeserializationContext(CustomDeserializationContext src) { super(src); }

    protected CustomDeserializationContext(CustomDeserializationContext src, DeserializerFactory factory) {
        super(src, factory);
    }

    @Override
    public DefaultDeserializationContext copy() {
        if (getClass() != CustomDeserializationContext.class) {
            return super.copy();
        }
        return new CustomDeserializationContext(this);
    }

    @Override
    public DefaultDeserializationContext createInstance(DeserializationConfig config,
                                                        JsonParser jp, InjectableValues values) {
        return new CustomDeserializationContext(this, config, jp, values);
    }

    @Override
    public DefaultDeserializationContext with(DeserializerFactory factory) {
        return new CustomDeserializationContext(this, factory);
    }

    @Override
    public boolean handleUnknownProperty(JsonParser p, JsonDeserializer<?> deser, Object instanceOrClass, String propName) throws IOException {
        final boolean originalResult = super.handleUnknownProperty(p, deser, instanceOrClass, propName);

        // log exception without throw it
        final Collection<Object> propIds = (deser == null) ? null : deser.getKnownPropertyNames();
        final UnrecognizedPropertyException e = UnrecognizedPropertyException.from(_parser, instanceOrClass, propName, propIds);
        logger.error("Unrecognized field is logged but ignored [FAIL_ON_UNKNOWN_PROPERTIES=false]", e);

        return originalResult;
    }
}
