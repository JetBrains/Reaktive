// Override ChromeHeadlessNoSandbox launcher to add --disable-dev-shm-usage,
// which is required on Linux CI agents where /dev/shm is limited in size.
config.set({
    customLaunchers: {
        ChromeHeadlessNoSandbox: {
            base: "ChromeHeadless",
            flags: ["--no-sandbox", "--disable-dev-shm-usage"]
        }
    }
});
