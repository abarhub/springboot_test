
Pour ajouter une interface dans account_api_description.yml :

```shell
yq eval ".components.schemas.Account.x-implements = \"org.exemple.MonInterface\"" -i "src/main/resources/account_api_description.yml"
```

pour modifier 2 objets :

```shell
yq eval ".components.schemas.Account.x-implements = \"org.exemple.MonInterface\" | .components.schemas.AccountNotFoundError.x-implements = \"org.exemple.MonInterface\" " -i "src/main/resources/account_api_description.yml"
```