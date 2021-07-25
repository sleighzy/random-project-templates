# Apache ZooKeeper

Ansible playbook to run the [Apache ZooKeeper] role.

## Requirements

Java: Java 8 / 11

## Install Role

The [run_playbook] script shows the complete steps for using a Python virtual
environment to isolate the installation of dependencies, install the role, and
then run the playbook against all hosts under the inventory directory.

Run the below command from the top-level directory to install the role using
this script.

```sh
run_playbook
```

Alternatively you can just run the bare minimum commands to install the role and
execute the playbook.

```sh
ansible-galaxy install -r requirements.yml
ansible-playbook -i inventory/ playbook.yaml
```

## Linting

Linting should be done using [ansible-lint]

```sh
pip3 install ansible-lint --user
```

[ansible-lint]: https://docs.ansible.com/ansible-lint/
[run_playbook]: ./run_playbook
[zookeeper]: https://github.com/sleighzy/ansible-zookeeper
