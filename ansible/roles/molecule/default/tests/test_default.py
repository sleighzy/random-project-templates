import os

import testinfra.utils.ansible_runner

testinfra_hosts = testinfra.utils.ansible_runner.AnsibleRunner(
    os.environ['MOLECULE_INVENTORY_FILE']).get_hosts('all')


def test_promtail_service_started_enabled(host):
    promtail_service = host.service('promtail')
    assert promtail_service.is_running
    assert promtail_service.is_enabled
