package br.com.javatar.votenorestaurante.model.base;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IncrementGenerator;

public class UseIdOrGenerate extends IncrementGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
        if (obj == null)
            throw new HibernateException(new NullPointerException());

        Serializable id = session.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, session);

        return id != null ? id : super.generate(session, obj);
    }
}
