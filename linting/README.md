# Linting

Place the appropriate files, depending on your project type, in this directory
at the top-level directory of your project.

- Linting
  - `.eslintrc.js`
- Markdown
  - `.markdownlint.json`
- Prettier
  - `prettier.config.js` - basic Prettier configuration
  - `prettierrc.yaml` - additional overrides for yaml files
  - `.prettierignore` - if wanting to ignore specific directories and files
- Terraform
  - `.tflint.hcl` - checks your Terraform scripts against AWS resources

Run the below command to install the linting dependencies.

```sh
npm install --save-dev eslint prettier eslint-config-airbnb eslint-config-prettier eslint-plugin-prettier lint-staged
```

Install the below VS Code extensions.

- <https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode>
- <https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint>
