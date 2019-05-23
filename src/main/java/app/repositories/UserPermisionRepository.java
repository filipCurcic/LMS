package app.repositories;

import java.util.Set;

import app.entities.UserPermission;

public interface UserPermisionRepository {

	Set<UserPermission> getByUserPermisionId(Long id);
}
